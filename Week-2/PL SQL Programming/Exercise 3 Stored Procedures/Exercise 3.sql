ALTER TABLE Customers ADD IsVIP CHAR(1);

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01),
        LastModified = SYSDATE
    WHERE AccountType = 'Savings';
END;
/

BEGIN
    ProcessMonthlyInterest;
END;
/

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    dept_name IN Employees.Department%TYPE,
    bonus_pct IN NUMBER
) IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * (bonus_pct / 100))
    WHERE Department = dept_name;
END;
/

BEGIN
    UpdateEmployeeBonus('IT', 10);
END;
/

CREATE PROCEDURE TransferFunds (
    from_account_id IN Accounts.AccountID%TYPE,
    to_account_id IN Accounts.AccountID%TYPE,
    amount IN NUMBER
) IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = from_account_id
    FOR UPDATE;

    IF v_balance < amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account.');
    ELSE
    
        UPDATE Accounts
        SET Balance = Balance - amount,
            LastModified = SYSDATE
        WHERE AccountID = from_account_id;

        UPDATE Accounts
        SET Balance = Balance + amount,
            LastModified = SYSDATE
        WHERE AccountID = to_account_id;
    END IF;
END;
/

BEGIN
    TransferFunds(1, 2, 500);
END;
/