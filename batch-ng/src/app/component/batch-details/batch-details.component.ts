import { OnInit } from '@angular/core';
import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { Batch } from 'src/app/model/batch';
import { Datasource } from 'src/app/model/datasource';
import { BatchService } from 'src/app/service/batch-service.service';

@Component({
  selector: 'app-batch-details',
  templateUrl: './batch-details.component.html',
  styleUrls: ['./batch-details.component.css']
})
export class BatchDetailsComponent implements OnInit {
  dataSourceEnum = Datasource;
  batch: Batch;
  batchId: any;

  constructor(private batchService: BatchService, private activatedRoute: ActivatedRoute, private _snackBar: MatSnackBar) {
    this.batch = new Batch();
  }

  ngOnInit(): void {
    if (this.activatedRoute.snapshot.paramMap.get('id')) {
      this.batchId = this.activatedRoute.snapshot.paramMap.get('id');
      this.batchService.getBatchById(parseInt(this.batchId)).subscribe(data => { this.batch = data });
    }
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
