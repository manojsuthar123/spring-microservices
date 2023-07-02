import { Injectable } from '@angular/core';
import { Batch } from '../model/batch';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { ApiConstant } from '../model/constant/api-constant';
import { Observable } from 'rxjs';
import { ResponseMessage } from '../model/response-message';

@Injectable({
  providedIn: 'root'
})
export class BatchService {
  batches: Batch[] = [];

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  getBatchList() : Observable<Batch[]>{
    return this.http.get<Batch[]>(ApiConstant.BATCH, this.httpOptions)
  }

  getBatchById(id: number) : Observable<Batch>{
    return this.http.get<Batch>(ApiConstant.BATCH+"/"+id, this.httpOptions)
  }

  deleteBatchById(id: number) : Observable<ResponseMessage>{
    return this.http.delete<ResponseMessage>(ApiConstant.BATCH+"/"+id, this.httpOptions)
  }

  createBatch(batch: Batch) : Observable<Batch> {
    return this.http.post<Batch>(ApiConstant.BATCH, batch, this.httpOptions);
  }

  startBatch(id: number) : Observable<ResponseMessage>{
    return this.http.get<ResponseMessage>(ApiConstant.BATCH+"/"+id+"/start", this.httpOptions)
  }

  stopBatch(id: number) : Observable<ResponseMessage>{
    return this.http.get<ResponseMessage>(ApiConstant.BATCH+"/"+id+"/stop", this.httpOptions)
  }

  errorHandler(){

  }
}
