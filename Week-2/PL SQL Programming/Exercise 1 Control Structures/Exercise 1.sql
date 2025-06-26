ALTER TABLE Customers ADD IsVIP CHAR(1);

DECLARE
    v_customer_id Customers.CustomerID%TYPE;
    v_dob Customers.DOB%TYPE;
    v_age NUMBER;
BEGIN
    FOR cust_rec IN (SELECT CustomerID, DOB FROM Customers) LOOP
        v_customer_id := cust_rec.CustomerID;
        v_dob := cust_rec.DOB;
        
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, v_dob)/12);
        
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = v_customer_id;
        END IF;
    END LOOP;
    
    COMMIT;
END;
/

BEGIN
    FOR cust IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF cust.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'Y'
            WHERE CustomerID = cust.CustomerID;
        ELSE
            UPDATE Customers
            SET IsVIP = 'N'
            WHERE CustomerID = cust.CustomerID;
        END IF;
    END LOOP;
    
    COMMIT;
END;
/

DECLARE
    CURSOR due_loans IS
        SELECT l.LoanID, l.CustomerID, l.EndDate, c.Name
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;

BEGIN
    FOR loan_rec IN due_loans LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || loan_rec.LoanID || 
                             ' for Customer ' || loan_rec.Name || 
                             ' is due on ' || TO_CHAR(loan_rec.EndDate, 'YYYY-MM-DD'));
    END LOOP;
END;
/