"use strict";
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
var React = require('react');
var react_router_1 = require('react-router');
var util_1 = require('../../util');
var OwnersTable_1 = require('./OwnersTable');
var getFilterFromLocation = function (location) {
    return location.query ? location.query.lastName : null;
};
var FindOwnersPage = (function (_super) {
    __extends(FindOwnersPage, _super);
    function FindOwnersPage(props) {
        _super.call(this, props);
        this.onFilterChange = this.onFilterChange.bind(this);
        this.submitSearchForm = this.submitSearchForm.bind(this);
        this.state = {
            filter: getFilterFromLocation(props.location)
        };
    }
    FindOwnersPage.prototype.componentDidMount = function () {
        var filter = this.state.filter;
        if (typeof filter === 'string') {
            // only load data on mount (initialy) if filter is specified
            // i.e. lastName query param in uri was set
            this.fetchData(filter);
        }
    };
    FindOwnersPage.prototype.componentWillReceiveProps = function (nextProps) {
        var location = nextProps.location;
        // read the filter from uri
        var filter = getFilterFromLocation(location);
        // set state
        this.setState({ filter: filter });
        // load data according to filter
        this.fetchData(filter);
    };
    FindOwnersPage.prototype.onFilterChange = function (event) {
        this.setState({
            filter: event.target.value
        });
    };
    /**
     * Invoked when the submit button was pressed.
     *
     * This method updates the URL with the entered lastName. The change of the URL
     * leads to new properties and thus results in rerending
     */
    FindOwnersPage.prototype.submitSearchForm = function () {
        var filter = this.state.filter;
        this.context.router.push({
            pathname: '/owners/list',
            query: { 'lastName': filter || '' }
        });
    };
    /**
     * Actually loads data from the server
     */
    FindOwnersPage.prototype.fetchData = function (filter) {
        var _this = this;
        var query = filter ? encodeURIComponent(filter) : '';
        var requestUrl = util_1.url('api/owner/list?lastName=' + query);
        fetch(requestUrl)
            .then(function (response) { return response.json(); })
            .then(function (owners) { _this.setState({ owners: owners }); });
    };
    FindOwnersPage.prototype.render = function () {
        var _a = this.state, filter = _a.filter, owners = _a.owners;
        return (<span>
        <section>
          <h2>Find Owners</h2>

          <form className='form-horizontal' action='javascript:void(0)'>
            <div className='form-group'>
              <div className='control-group' id='lastName'>
                <label className='col-sm-2 control-label'>Last name </label>
                <div className='col-sm-10'>
                  <input className='form-control' name='filter' value={filter || ''} onChange={this.onFilterChange} size={30} maxLength={80}/>
                  
                </div>
              </div>
            </div>
            <div className='form-group'>
              <div className='col-sm-offset-2 col-sm-10'>
                <button type='button' onClick={this.submitSearchForm} className='btn btn-default'>Find Owner</button>
              </div>
            </div>
          </form>
        </section>
        <OwnersTable_1.default owners={owners}/>
        <react_router_1.Link className='btn btn-default' to='/owners/new'> Add Owner</react_router_1.Link>
      </span>);
    };
    FindOwnersPage.contextTypes = {
        router: React.PropTypes.object.isRequired
    };
    return FindOwnersPage;
}(React.Component));
Object.defineProperty(exports, "__esModule", { value: true });
exports.default = FindOwnersPage;
;
