import React from "react";

export default function CourseDetails({ courses }) {
  return (
    <div className="mystyle1">
      <h1>Course Details</h1>
      {courses.map((course, index) => (
        <div key={index}>
          <h2>{course.name}</h2>
          <h4>{course.date}</h4>
        </div>
      ))}
    </div>
  );
}
