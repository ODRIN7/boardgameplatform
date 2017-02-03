"use strict";
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
var React = require('react');
var util_1 = require('../../util');
var Constraints_1 = require('../form/Constraints');
var DateInput_1 = require('../form/DateInput');
var Input_1 = require('../form/Input');
var PetDetails_1 = require('./PetDetails');
var VisitsPage = (function (_super) {
    __extends(VisitsPage, _super);
    function VisitsPage(props) {
        _super.call(this, props);
        this.onInputChange = this.onInputChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }
    VisitsPage.prototype.componentDidMount = function () {
        var _this = this;
        var params = this.props.params;
        if (params && params.ownerId) {
            fetch(util_1.url("/api/owner/" + params.ownerId))
                .then(function (response) { return response.json(); })
                .then(function (owner) { return _this.setState({
                owner: owner,
                visit: { id: null, isNew: true, date: null, description: '' }
            }); });
        }
    };
    VisitsPage.prototype.onSubmit = function (event) {
        var _this = this;
        event.preventDefault();
        var petId = this.props.params.petId;
        var _a = this.state, owner = _a.owner, visit = _a.visit;
        var request = {
            date: visit.date,
            description: visit.description
        };
        var url = '/api/owners/' + owner.id + '/pets/' + petId + '/visits';
        util_1.submitForm('POST', url, request, function (status, response) {
            if (status === 204) {
                _this.context.router.push({
                    pathname: '/owners/' + owner.id
                });
            }
            else {
                console.log('ERROR?!...', response);
                _this.setState({ error: response });
            }
        });
    };
    VisitsPage.prototype.onInputChange = function (name, value) {
        var visit = this.state.visit;
        this.setState({ visit: Object.assign({}, visit, (_a = {}, _a[name] = value, _a)) });
        var _a;
    };
    VisitsPage.prototype.render = function () {
        if (!this.state) {
            return <h2>Loading...</h2>;
        }
        var _a = this.state, owner = _a.owner, error = _a.error, visit = _a.visit;
        var petId = this.props.params.petId;
        var pet = owner.pets.find(function (candidate) { return candidate.id.toString() === petId; });
        return (<div>
        <h2>Visits</h2>
        <b>Pet</b>
        <PetDetails_1.default owner={owner} pet={pet}/>

        <form className='form-horizontal' method='POST' action={util_1.url('/api/owner')}>
          <div className='form-group has-feedback'>
            <DateInput_1.default object={visit} error={error} label='Date' name='date' onChange={this.onInputChange}/>
            <Input_1.default object={visit} error={error} constraint={Constraints_1.NotEmpty} label='Description' name='description' onChange={this.onInputChange}/>
          </div>
          <div className='form-group'>
            <div className='col-sm-offset-2 col-sm-10'>
              <button className='btn btn-default' type='submit' onClick={this.onSubmit}>Add Visit</button>
            </div>
          </div>
        </form>
      </div>);
    };
    VisitsPage.contextTypes = {
        router: React.PropTypes.object.isRequired
    };
    return VisitsPage;
}(React.Component));
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = VisitsPage;
