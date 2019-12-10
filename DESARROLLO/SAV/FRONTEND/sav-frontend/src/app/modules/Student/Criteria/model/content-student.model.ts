export interface SubContent {
  nombre: string,
  lsSubContenido: ItemSubContent[]
}

export interface ItemSubContent {
  idSubContenido: number
  nombre: string
  descripcion: string
  urlImagen: string
  flag?: boolean
}
