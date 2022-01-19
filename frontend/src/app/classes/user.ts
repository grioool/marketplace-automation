export class User {
  constructor(
    public id: number,
    public name: string,
    public email: string,
    public password: string,
    public username: string,
    public nameCompany: string,
    public wildBerriesKeys: string,
    public ozonKey: string,
    public isBlocked: boolean,
    public isSubscribed: boolean
    ) { }
}
