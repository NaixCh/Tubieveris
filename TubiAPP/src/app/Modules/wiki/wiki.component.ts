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
        titleAcordeon: 'Elementos ',
        icon: 'plus.png',
        ocultar : 'hidden',
        open : '',
        elementTitle1: 'Gasolina',
        elementDescripcion1: 'Elementos espaciales que sirven para aguantar mas en el juego',
        elementTitle2: '',
        elementDescripcion2: '',
        elementTitle3: '',
        elementDescripcion3: ''
      },
      {
        titleAcordeon: 'PowerUp ',
        icon: 'plus.png',
        ocultar : 'hidden',
        open : '',
        elementTitle1: 'Laser',
        elementDescripcion1: 'el mega laser destructor',
        elementTitle2: '',
        elementDescripcion2: '',
        elementTitle3: '',
        elementDescripcion3: ''
      },
      {
        titleAcordeon: 'Mr.Tubilleja ',
        icon: 'plus.png',
        ocultar : 'hidden',
        open : '',
        elementTitle1: 'Tubilleja',
        elementDescripcion1: 'Comandante espacial de la nave',
        elementTitle2: '',
        elementDescripcion2: '',
        elementTitle3: '',
        elementDescripcion3: ''
      }
    ];
  }

  openAccordion(icon, e) { 
    if (icon == 'plus.png' ) {
      console.log("abrir");
      this.questionAndAnwers[e].ocultar = '';
      this.questionAndAnwers[e].icon = 'minus.png';
      this.questionAndAnwers[e].open = 'openedAcordion';
    } else {
      console.log("cerrar");
      this.questionAndAnwers[e].ocultar = 'hidden';
      this.questionAndAnwers[e].icon = 'plus.png';
      this.questionAndAnwers[e].open = '';
    }
  }

}
