import axios from 'axios';

import { ISelecaoPescProcess } from '@/shared/model/selecao-pesc-process.model';

const baseApiUrl = 'api/selecao-pesc-processes';

export default class SelecaoPescProcessService {
  public find(id: number): Promise<ISelecaoPescProcess> {
    return new Promise<ISelecaoPescProcess>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${id}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public retrieve(): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(baseApiUrl)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public create(entity: ISelecaoPescProcess): Promise<ISelecaoPescProcess> {
    return new Promise<ISelecaoPescProcess>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}`, entity)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
