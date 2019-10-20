import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-wiki',
  templateUrl: './wiki.component.html',
  styleUrls: ['./wiki.component.css']
})
export class WikiComponent implements OnInit {

  pathImage = "assets/images/";
  questionAndAnwers;

  constructor() { }

  ngOnInit() {
      this.questionAndAnwers = [{
        titleAcordeon: '¿Qué es el Idufir? ',
        icon: 'plus.png',
        ocultar : 'hide',
        elementTitle1: '',
        elementDescripcion1: '',
        elementTitle2: '',
        elementDescripcion2: ''
      },
      {
        titleAcordeon: '¿Qué es el Idufir? ',
        icon: 'plus.png',
        ocultar : 'hide',
        elementTitle1: '',
        elementDescripcion1: '',
        elementTitle2: '',
        elementDescripcion2: ''
      },
      {
        titleAcordeon: '¿Qué es el Idufir? ',
        icon: 'plus.png',
        ocultar : 'hide',
        elementTitle1: '',
        elementDescripcion1: '',
        elementTitle2: '',
        elementDescripcion2: ''
      }
    ];
  }

  openAccordion(icon, e) { 
    if (icon == 'plus.png' ) {
      console.log("abrir");
      this.questionAndAnwers[e].ocultar = '';
      this.questionAndAnwers[e].icon = 'minus.png';
    } else {
      console.log("cerrar");
      this.questionAndAnwers[e].ocultar = 'hidden';
      this.questionAndAnwers[e].icon = 'plus.png';
    }
  }

}
