import React from "react";

export default function BlogDetails({ blogs }) {
  return (
    <div className="v1">
      <h1>Blog Details</h1>
      {blogs.map((blog, index) => (
        <div key={index}>
          <h2>{blog.title}</h2>
          <h4>
            <i>{blog.author}</i>
          </h4>
          <p>{blog.content}</p>
        </div>
      ))}
    </div>
  );
}
