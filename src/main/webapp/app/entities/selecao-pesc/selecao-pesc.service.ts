import axios from 'axios';

import { ISelecaoPesc } from '@/shared/model/selecao-pesc.model';

const baseApiUrl = 'api/selecao-pescs';

export default class SelecaoPescService {
  public find(id: number): Promise<ISelecaoPesc> {
    return new Promise<ISelecaoPesc>((resolve, reject) => {
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
}
