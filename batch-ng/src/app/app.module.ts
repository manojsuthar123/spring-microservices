import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatListModule } from '@angular/material/list';
import { HomeComponent } from './component/home/home.component';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap'
import { MatSnackBarModule, MAT_SNACK_BAR_DEFAULT_OPTIONS } from '@angular/material/snack-bar';
import { BatchListComponent } from './component/batch-list/batch-list.component';
import { CreateBatchComponent } from './component/create-batch/create-batch.component';
import { AppComponent } from './component/app/app.component';
import { HttpClientModule } from '@angular/common/http';
import { BatchDetailsComponent } from './component/batch-details/batch-details.component';
import {MatCheckboxModule} from '@angular/material/checkbox';

@NgModule({
  declarations: [
    AppComponent,
    BatchListComponent,
    CreateBatchComponent,
    HomeComponent,
    BatchDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatGridListModule,
    MatCardModule,
    MatButtonModule,
    MatListModule,
    FormsModule,
    NgbModule,
    MatSnackBarModule,
    HttpClientModule  ,
    MatCheckboxModule
  ],
  providers: [
    {provide: MAT_SNACK_BAR_DEFAULT_OPTIONS, useValue: {duration: 2500}}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
