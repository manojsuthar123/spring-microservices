import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms'
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { Batch } from 'src/app/model/batch';
import { Datasource } from 'src/app/model/datasource';
import { BatchService } from 'src/app/service/batch-service.service';


@Component({
  selector: 'app-create-batch',
  templateUrl: './create-batch.component.html',
  styleUrls: ['./create-batch.component.css']
})
export class CreateBatchComponent implements OnInit {
  dataSourceEnum = Datasource;
  batch: Batch;
  batchId: any;

  constructor(private batchService: BatchService, private activatedRoute: ActivatedRoute,private _snackBar: MatSnackBar) {
    this.batch = new Batch();
  }

  ngOnInit(): void {
    if (this.activatedRoute.snapshot.paramMap.get('id')) {
      this.batchId = this.activatedRoute.snapshot.paramMap.get('id');
      this.batchService.getBatchById(parseInt(this.batchId)).subscribe(data => {this.batch = data});
    }
  }

  onSubmit() {
    this.batchService.createBatch(this.batch).subscribe({
      error: (err) => { console.error(err) },
      complete: () => { this._snackBar.open('Batch saved!', 'OK') },
    });
  }

}
