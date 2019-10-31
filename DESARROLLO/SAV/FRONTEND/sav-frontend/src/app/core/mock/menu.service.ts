export class MenuService {
  static menuStudents(){
    return [
      {
        title: 'Tareas',
        key: 'Tareas',
        url: '/student/homework',
        icon: 'file-text',
      },
      {
        title: 'Examenes',
        key: 'Examenes',
        url: '/student/courses',
        icon: 'profile',
      },
      {
        title: 'Historial',
        key: 'Historial',
        url: '/student/history-homework',
        icon: 'read',
      },
      {
        title: 'Criterios',
        key: 'Criterios',
        url: '/student/criteria',
        icon: 'copy',
      },
    ]
  }

  static menuTeachers(){
    return [
      {
        title: 'Tareas',
        key: 'Tareas',
        url: '/student/homework',
        icon: 'file-text',
      },
      {
        title: 'Examenes',
        key: 'Examenes',
        url: '/student/courses',
        icon: 'profile',
      },
      {
        title: 'Historial',
        key: 'Historial',
        url: '/student/history-homework',
        icon: 'read',
      },
      {
        title: 'Criterios',
        key: 'Criterios',
        url: '/student/history-homework',
        icon: 'copy',
      },
    ]
  }
}
