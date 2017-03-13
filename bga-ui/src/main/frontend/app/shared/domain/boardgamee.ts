export class BoardGame {

  private _id: number;
  private _icon: String;
  private _name: String;
  private _typeOfBoardGames: string[];
  private _shortDescription: String;
  private _rules: string[];
  private _pdfDescription: String;
  private _price: number;


  constructor(id: number, icon: String, name: String, typeOfBoardGames: string[], shortDescription: String, rules: string[], pdfDescription: String, price: number) {
    this._id = id;
    this._icon = icon;
    this._name = name;
    this.typeOfBoardGames = typeOfBoardGames;
    this._shortDescription = shortDescription;
    this._rules = rules;//todo hülyeség
    this._pdfDescription = pdfDescription;
    this._price = price;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get icon(): String {
    return this._icon;
  }

  set icon(value: String) {
    this._icon = value;
  }

  get name(): String {
    return this._name;
  }

  set name(value: String) {
    this._name = value;
  }

  get typeOfBoardGames(): string[] {
    return this._typeOfBoardGames;
  }

  set typeOfBoardGames(value: string[]) {
    this._typeOfBoardGames = value;
  }

  get shortDescription(): String {
    return this._shortDescription;
  }

  set shortDescription(value: String) {
    this._shortDescription = value;
  }

  get rules(): string[] {
    return this._rules;
  }

  set rules(value: string[]) {
    this._rules = value;
  }

  get pdfDescription(): String {
    return this._pdfDescription;
  }

  set pdfDescription(value: String) {
    this._pdfDescription = value;
  }

  get price(): number {
    return this._price;
  }

  set price(value: number) {
    this._price = value;
  }
}
