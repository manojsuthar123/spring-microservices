import { Component, Input } from '@angular/core';
import { Batch } from 'src/app/model/batch';
import { BatchService } from 'src/app/service/batch-service.service';

@Component({
  selector: 'app-batch-list',
  templateUrl: './batch-list.component.html',
  styleUrls: ['./batch-list.component.css']
})
export class BatchListComponent {
  @Input('batch') batch: Batch;

  constructor(private batchService: BatchService) {
    this.batch = new Batch();
  }

  deleteBatch(batchId: number){
    this.batchService.deleteBatchById(batchId)
    .subscribe(data => {
      console.log(data.toString())
    });
  }
}
