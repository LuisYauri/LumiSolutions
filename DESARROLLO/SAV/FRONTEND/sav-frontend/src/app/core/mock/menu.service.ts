export class MenuService {
  static menuStudents() {
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

  static menuTeachers() {
    return [
      {
        title: 'Tareas',
        key: 'Tareas',
        url: '/teacher-group/homework',
        icon: 'file-text',
      },
      {
        title: 'Examenes',
        key: 'Examenes',
        url: '/teacher-group/examn',
        icon: 'profile',
      },
      {
        title: 'Historial',
        key: 'Historial',
        url: '/teacher-group/history',
        icon: 'read',
      },
      {
        title: 'Estudiantes',
        key: 'Criterios',
        url: '/teacher-group/students',
        icon: 'team',
      },
      {
        title: 'Preguntas',
        key: 'Preguntas',
        url: '/teacher-group/questions',
        icon: 'message',
      },
    ]
  }
}
