import React, { useState } from "react";
import BookDetails from "./components/BookDetails";
import BlogDetails from "./components/BlogDetails";
import CourseDetails from "./components/CourseDetails";

import { books, blogs, courses } from "./data";

function App() {
  const [showBook, setShowBook] = useState(true);
  const [showBlog, setShowBlog] = useState(true);
  const [showCourse, setShowCourse] = useState(true);

  return (
    <div style={{ display: "flex", justifyContent: "space-around" }}>
      {/* Conditional Rendering: Using && */}
      {showCourse && <CourseDetails courses={courses} />}

      {/* Conditional Rendering: Using ternary operator */}
      {showBook ? (
        <BookDetails books={books} />
      ) : (
        <p>No Book Details Available</p>
      )}

      {/* Conditional Rendering: Storing in variable */}
      {(() => {
        if (showBlog) {
          return <BlogDetails blogs={blogs} />;
        } else {
          return <p>Blog section hidden</p>;
        }
      })()}
    </div>
  );
}

export default App;
