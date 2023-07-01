import { Status } from "./batch-status";
import { Datasource } from "./datasource";

export class Batch {

  constructor(
    public id: number = 0,
    public name: string = '',

    //data source
    public dataSource: Datasource = Datasource.DATABASE,
    public dataSourceFile: string = '',
    public dataSourceUrl: string = '',
    public dataSourceUsername: string = '',
    public dataSourcePassword: string = '',

    //data destination
    public dataDestination: Datasource = Datasource.DATABASE,
    public dataDestFile: string = '',
    public dataDestUrl: string = '',
    public dataDestUsername: string = '',
    public dataDestPassword: string = '',

    public isRunning: boolean = false,
    public isMail: boolean = false,
    public mail: string = '',
    public status: Status = Status.INITIALIZE,
    public createdAt: string = new Date().toString(),
    public startDateTime: string = new Date().toString()
  ) {}
}
