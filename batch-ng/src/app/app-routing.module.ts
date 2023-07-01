import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateBatchComponent } from './component/create-batch/create-batch.component';
import { HomeComponent } from './component/home/home.component';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: HomeComponent
  },
  {
    path: 'batch',
    component: CreateBatchComponent
  },
  {
    path: ':id/edit',
    component: CreateBatchComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
