import { Component, Input } from '@angular/core';
import { Batch } from 'src/app/model/batch';
import { BatchService } from 'src/app/service/batch-service.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-batch-list',
  templateUrl: './batch-list.component.html',
  styleUrls: ['./batch-list.component.css']
})
export class BatchListComponent {
  @Input('batch') batch: Batch;

  constructor(private batchService: BatchService, private _snackBar: MatSnackBar) {
    this.batch = new Batch();
  }

  deleteBatch(batchId: number){
    this.batchService.deleteBatchById(batchId)
    .subscribe(data => {
      this._snackBar.open(data.message, 'OK')
    });
  }

  startBatch(batchId: number){
    this.batchService.startBatch(batchId)
    .subscribe(data => {
      this.batch.isRunning = true;
      this._snackBar.open(data.message, 'OK')
    });
  }

  stopBatch(batchId: number){
    this.batchService.stopBatch(batchId)
    .subscribe(data => {
      this.batch.isRunning = false;
      this._snackBar.open(data.message, 'OK')
    });
  }
}
