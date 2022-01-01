export class User{
  constructor(
    public _id: number,
    public name: string,
    public email: string,
    public password: string,
    public wildBerriesKeys: string,
    public ozonKey: string,
    public isBlocked: boolean,
    public isSubscribed: boolean
    ) { }
}
