import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Content} from "../../../../model/criteria-student.model";
import {interval, Observable} from "rxjs";
import {NguCarouselConfig} from "@ngu/carousel";
import {map, startWith, take} from "rxjs/operators";

@Component({
  selector: 'app-content-carousel-criteria',
  templateUrl: './content-carousel-criteria.component.html',
  styleUrls: ['./content-carousel-criteria.component.scss']
})
export class ContentCarouselCriteriaComponent implements OnInit {

  @Input() listContent: Content[] = null
  @Output() getContent = new EventEmitter();

  carouselTileItems$: Observable<Content[]>;
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
      take(this.listContent.length),
      map(val => {
        return this.listContent;
      })
    );

  }

  sendContent(item: Content) {
    this.getContent.emit(item)
  }
}
