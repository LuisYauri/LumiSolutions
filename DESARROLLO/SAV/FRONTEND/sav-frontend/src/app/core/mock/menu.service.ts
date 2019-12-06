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
        title: 'Exámenes',
        key: 'Examenes',
        url: '/student/examn',
        icon: 'profile',
      },
      {
        title: 'Historial',
        key: 'Historial',
        url: '/student/history',
        icon: 'read',
      },
      {
        title: 'Competencias',
        key: 'Competencias',
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
        url: '/student/historya-homework',
        icon: 'read',
      },
      {
        title: 'Criterios',
        key: 'Criterios',
        url: '/student/historya-homework',
        icon: 'copy',
      },
    ]
  }
}
