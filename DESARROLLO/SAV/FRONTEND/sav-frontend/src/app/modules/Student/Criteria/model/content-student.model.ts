export interface SubContent {
  nombre: string,
  lsSubContenidos: ItemSubContent[]
}

export interface ItemSubContent {
  idSubContenido: number
  nombre: string
  descripcion: string
  urlImagen: string
}
