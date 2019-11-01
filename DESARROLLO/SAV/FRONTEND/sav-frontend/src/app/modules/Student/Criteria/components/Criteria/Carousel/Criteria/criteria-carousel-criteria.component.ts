import {Component, Input, OnInit} from '@angular/core';
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
    console.log(this.listCriteria)
    this.carouselTileItems$ = interval(500).pipe(
      startWith(-1),
      take(this.listCriteria.length),
      map(val => {
        return this.listCriteria;
      })
    );

  }


  selectItem(item: Criteria) {
    console.log(item)
  }
}
