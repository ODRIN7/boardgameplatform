"use strict";
var React = require('react');
var react_router_1 = require('react-router');
var VisitsTable = function (_a) {
    var ownerId = _a.ownerId, pet = _a.pet;
    return (<table className='table-condensed'>
    <thead>
      <tr>
        <th>Visit Date</th>
        <th>Description</th>
      </tr>
    </thead>
    <tbody>
      {pet.visits.map(function (visit) { return (<tr key={visit.id}>
          <td>{visit.date}</td>
          <td>{visit.description}</td>
        </tr>); })}
      <tr>
        <td>
          <react_router_1.Link to={"/owners/" + ownerId + "/pets/" + pet.id + "/edit"}>Edit Pet</react_router_1.Link>
        </td>
        <td>
          <react_router_1.Link to={"/owners/" + ownerId + "/pets/" + pet.id + "/visits/new"}>Add Visit</react_router_1.Link>
        </td>
      </tr>
    </tbody>
  </table>);
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = function (_a) {
    var owner = _a.owner;
    return (<section>
    <h2>Pets and Visits</h2>
    <table className='table table-striped'>
      <tbody>
        {owner.pets.map(function (pet) { return (<tr key={pet.id}>
            <td style={{ 'verticalAlign': 'top' }}>
              <dl className='dl-horizontal'>
                <dt>Name</dt>
                <dd>{pet.name}</dd>
                <dt>Birth Date</dt>
                <dd>{pet.birthDate}</dd>
                <dt>Type</dt>
                <dd>{pet.type.name}</dd>
              </dl>
            </td>
            <td style={{ 'verticalAlign': 'top' }}>
              <VisitsTable ownerId={owner.id} pet={pet}/>
            </td>
          </tr>); })}
      </tbody>
    </table>
  </section>);
};
