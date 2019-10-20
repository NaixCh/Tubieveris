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
    this.imagelist = [ 'imagen1.png',
                       'imagen2.jpg',
                       'imagen3.jpg',
                       'imagen1.png',
                       'imagen2.jpg',
                       'imagen3.jpg',
                       'imagen1.png',
                       'imagen2.jpg'
						      ];


  }


}
