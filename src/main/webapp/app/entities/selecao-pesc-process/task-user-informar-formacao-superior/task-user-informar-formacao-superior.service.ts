import axios from 'axios';
import { TaskUserInformarFormacaoSuperiorContext } from './task-user-informar-formacao-superior.model';

const baseApiUrl = 'api/selecao-pesc-process/task-user-informar-formacao-superior';

export default class TaskUserInformarFormacaoSuperiorService {
  public loadContext(taskId: number): Promise<TaskUserInformarFormacaoSuperiorContext> {
    return new Promise<TaskUserInformarFormacaoSuperiorContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public claim(taskId: number): Promise<TaskUserInformarFormacaoSuperiorContext> {
    return new Promise<TaskUserInformarFormacaoSuperiorContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}/claim`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public complete(taskUserInformarFormacaoSuperiorContext: TaskUserInformarFormacaoSuperiorContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskUserInformarFormacaoSuperiorContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
