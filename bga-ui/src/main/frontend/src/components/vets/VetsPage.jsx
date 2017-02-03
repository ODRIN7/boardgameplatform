"use strict";
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
var React = require('react');
var util_1 = require('../../util');
var VetsPage = (function (_super) {
    __extends(VetsPage, _super);
    function VetsPage() {
        _super.call(this);
        this.state = { vets: [] };
    }
    VetsPage.prototype.componentDidMount = function () {
        var _this = this;
        var requestUrl = util_1.url('api/vets');
        fetch(requestUrl)
            .then(function (response) { return response.json(); })
            .then(function (vets) { console.log('vets', vets); _this.setState({ vets: vets }); });
    };
    VetsPage.prototype.render = function () {
        var vets = this.state.vets;
        if (!vets) {
            return <h2>Veterinarians</h2>;
        }
        return (<span>
        <h2>Veterinarians</h2>
        <table className='table table-striped'>
          <thead>
            <tr>
              <th>Name</th>
              <th>Specialties</th>
            </tr>
          </thead>
          <tbody>

            {vets.map(function (vet) { return (<tr key={vet.id}>
                <td>{vet.firstName} {vet.lastName}</td>
                <td>{vet.specialties.length > 0 ? vet.specialties.map(function (specialty) { return specialty.name; }).join(', ') : 'none'}</td>
              </tr>); })}
          </tbody>
        </table>
      </span>);
    };
    return VetsPage;
}(React.Component));
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = VetsPage;
