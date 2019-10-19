import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  rowLinks: any[];

  constructor() { }

  ngOnInit() {
  this.rowLinks = [
							      {
								      name: 'INICIO',
								      href: '/inicio'
							      },
							      {
								      name: 'DEMO',
								      href: '/demo'
							      },
							      {
								      name: 'DESCARGA',
								      href: '/descarga'
							      },
							      {
								      name: 'WIKI',
								      href: '/wiki'
							      }
						      ]
  }

}
