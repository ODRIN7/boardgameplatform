"use strict";
var React = require('react');
var renderRow = function (owner) { return (<tr key={owner.id}>
    <td>
      <a href={"/owners/" + owner.id}>
        {owner.firstName} {owner.lastName}
      </a>
    </td>
    <td className='hidden-sm hidden-xs'>{owner.address}</td>
    <td>{owner.city}</td>
    <td>{owner.telephone}</td>
    <td className='hidden-xs'>{owner.pets.map(function (pet) { return pet.name; }).join(', ')}</td>
  </tr>); };
var renderOwners = function (owners) { return (<section>
    <h2>{owners.length} Owners found</h2>
    <table className='table table-striped'>
      <thead>
        <tr>
          <th>Name</th>
          <th className='hidden-sm hidden-xs'>Address</th>
          <th>City</th>
          <th>Telephone</th>
          <th className='hidden-xs'>Pets</th>
        </tr>
      </thead>
      <tbody>
        {owners.map(renderRow)}
      </tbody>
    </table>
  </section>); };
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = function (_a) {
    var owners = _a.owners;
    return owners ? renderOwners(owners) : null;
};
