import {Component, Input, OnInit} from '@angular/core';
import {NzModalRef} from "ng-zorro-antd/modal";

@Component({
  selector: 'app-delete-modal-teacher',
  templateUrl: './delete-modal-teacher.component.html',
  styleUrls: ['./delete-modal-teacher.component.scss']
})
export class DeleteModalTeacherComponent implements OnInit {
  @Input() subtitle: string = null
  @Input() description: string = null

  constructor(private modal: NzModalRef) { }

  ngOnInit() {
  }

  sendYes() {
    this.modal.destroy({status: true})
  }

  close() {
    this.modal.destroy()
  }
}
