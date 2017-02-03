"use strict";
var React = require('react');
var react_router_1 = require('react-router');
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = function (_a) {
    var owner = _a.owner;
    return (<section>
    <h2>Owner Information</h2>

    <table className='table table-striped'>
      <tbody>
        <tr>
          <th>Name</th>
          <td><b>{owner.firstName} {owner.lastName}</b></td>
        </tr>
        <tr>
          <th>Address</th>
          <td>{owner.address}</td>
        </tr>
        <tr>
          <th>City</th>
          <td>{owner.city}</td>
        </tr>
        <tr>
          <th>Telephone</th>
          <td>{owner.telephone}</td>
        </tr>
      </tbody>
    </table>

    <react_router_1.Link to={"/owners/" + owner.id + "/edit"} className='btn btn-default'>Edit Owner</react_router_1.Link>
    &nbsp;
    <react_router_1.Link to={"/owners/" + owner.id + "/pets/new"} className='btn btn-default'>Add New Pet</react_router_1.Link>
  </section>);
};
