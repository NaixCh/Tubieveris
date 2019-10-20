import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-download',
  templateUrl: './download.component.html',
  styleUrls: ['./download.component.css']
})
export class DownloadComponent implements OnInit {


  imagelist: any[];
  pathImage = "assets/images/downloads/";

  constructor() { }

  ngOnInit() {
    this.imagelist = [ 'Imagen1.PNG',
                       'Imagen2.PNG',
                       'Imagen3.PNG',
                       'Imagen4.PNG'
						      ];


  }


}
