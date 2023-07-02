export enum ResponseCode {
    SUCCESS = 'SUCCESS',
    FAILED = 'FAILED'
}

export class ResponseMessage {
    constructor(
        public code: ResponseCode,
        public message: string
      ) {}
}