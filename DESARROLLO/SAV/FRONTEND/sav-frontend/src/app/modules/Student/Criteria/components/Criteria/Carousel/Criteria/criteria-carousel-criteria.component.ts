import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {interval, Observable} from "rxjs";
import {NguCarouselConfig} from "@ngu/carousel";
import {map, startWith, take} from "rxjs/operators";
import {Criteria} from "../../../../model/criteria.model";

@Component({
  selector: 'app-criteria-carousel-criteria',
  templateUrl: './criteria-carousel-criteria.component.html',
  styleUrls: ['./criteria-carousel-criteria.component.scss']
})
export class CriteriaCarouselCriteriaComponent implements OnInit {

  @Input() listCriteria: Criteria[] = null
  @Output() getCriterio = new EventEmitter();


  carouselTileItems$: Observable<Criteria[]>;
  carouselTileConfig: NguCarouselConfig = {
    grid: {xs: 1, sm: 1, md: 1, lg: 5, all: 0},
    speed: 0,
    point: {
      visible: false
    },
    touch: true,
    loop: true,
    interval: {timing: 20000},
    animation: 'lazy'
  };

  constructor() {
  }

  ngOnInit() {
    this.carouselTileItems$ = interval(10000).pipe(
      startWith(-1),
      take(this.listCriteria.length),
      map(val => {
        return this.listCriteria;
      })
    );

  }

  sendCriterio(item: Criteria) {
    this.getCriterio.emit(item)
  }
}
