import React from "react";

export class Cart extends React.Component {
  render() {
    return (
      <table
        border="1"
        align="center"
        cellPadding="10"
        style={{ color: "green" }}
      >
        <thead>
          <tr>
            <th>Name</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          {this.props.item.map((item, index) => {
            return (
              <tr key={index}>
                <td>{item.itemname}</td>
                <td>{item.price}</td>
              </tr>
            );
          })}
        </tbody>
      </table>
    );
  }
}
