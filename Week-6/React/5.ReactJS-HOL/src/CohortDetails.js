import React from "react";
import styles from "./CohortDetails.module.css";

const CohortDetails = ({ cohortCode, startDate, status, coach, trainer }) => {
  const titleColor = status === "ongoing" ? "green" : "blue";

  return (
    <div className={styles.box}>
      <div className={styles.title} style={{ color: titleColor }}>
        {cohortCode}
      </div>
      <dl>
        <dt>Started On</dt>
        <dd>{startDate}</dd>

        <dt>Current Status</dt>
        <dd>{status}</dd>

        <dt>Coach</dt>
        <dd>{coach}</dd>

        <dt>Trainer</dt>
        <dd>{trainer}</dd>
      </dl>
    </div>
  );
};

export default CohortDetails;
