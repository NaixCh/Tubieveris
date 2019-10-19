import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';
import { GameComponent } from './Modules/game/game.component';
import { WikiComponent } from './Modules/wiki/wiki.component';
import { DownloadComponent } from './Modules/download/download.component';
import { InicioComponent } from './Modules/inicio/inicio.component';

const routes: Routes = [
  { path: '', redirectTo: '/inicio', pathMatch: 'full' },
  { path: 'inicio', component: InicioComponent },
  { path: 'demo', component: GameComponent },
  { path: 'descarga', component: DownloadComponent },
  { path: 'wiki', component: WikiComponent },
  { path: '**', component: InicioComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
