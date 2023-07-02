import { Component, OnInit } from '@angular/core';
import { Batch } from '../../model/batch';
import { BatchService } from '../../service/batch-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  batchName = 'Spring Batch';
  runningCount = 0;
  completedCount = 0;
  batches: Batch[] = [];
  isLoading = true;
  isError = false;

  constructor(private batchService: BatchService) { }

  ngOnInit(): void {
    this.isLoading = true;
    this.isError = false;
    this.batchService.getBatchList()
      .subscribe({
        next: (data) => {
          this.batches = data;
          this.runningCount = this.batches.filter((batch) => batch.isRunning == true).length;
        },
        error: (err) => {
          this.isError = true;
        },
        complete: () => {
          this.isLoading = false;
        }
      });
  }

}
