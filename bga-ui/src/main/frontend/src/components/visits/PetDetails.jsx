"use strict";
var React = require('react');
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = function (_a) {
    var owner = _a.owner, pet = _a.pet;
    return (<table className='table table-striped'>
    <thead>
      <tr>
        <th>Name</th>
        <th>Birth Date</th>
        <th>Type</th>
        <th>Owner</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>{pet.name}</td>
        <td>{pet.birthDate}</td>
        <td>{pet.type.name}</td>
        <td>{owner.firstName} {owner.lastName}</td>
      </tr>
    </tbody>
  </table>);
};
