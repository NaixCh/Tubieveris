import { Component, OnInit } from '@angular/core';
import { UnityLoader } from 'unity-loader';

declare let window: any;

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {

  private gameInstance: any;

  constructor() {
  }

  ngOnInit() {
    window.UnityLoader = UnityLoader;
    this.gameInstance = UnityLoader.instantiate("gamecontainer", "../assets/Builds.json");
  }

}
