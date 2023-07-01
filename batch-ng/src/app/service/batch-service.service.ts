import { Injectable } from '@angular/core';
import { Batch } from '../model/batch';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { ApiConstant } from '../model/constant/api-constant';
import { Observable } from 'rxjs';

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

  deleteBatchById(id: number) : Observable<string>{
    return this.http.delete<string>(ApiConstant.BATCH+"/"+id, this.httpOptions)
  }

  createBatch(batch: Batch) : Observable<Batch> {
    return this.http.post<Batch>(ApiConstant.BATCH, batch, this.httpOptions);
  }

  errorHandler(){

  }
}
