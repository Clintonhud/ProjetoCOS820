import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { ITaskInstance } from '@/shared/model/task-instance.model';

import TaskInstanceService from './task-instance.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class TaskInstance extends Vue {
  @Inject('taskInstanceService') private taskInstanceService: () => TaskInstanceService;

  public taskInstances: ITaskInstance[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveTaskInstances();
  }

  public clear(): void {
    this.retrieveTaskInstances();
  }

  public retrieveTaskInstances(): void {
    if (this.onlyTasksAssignedToMe) {
      return this.retrieveMyAssignedTaskInstances();
    }
    return this.retrieveMyCandidateTaskInstances();
  }

  public retrieveMyCandidateTaskInstances(): void {
    this.isFetching = true;

    this.taskInstanceService()
      .retrieveMyCandidateTaskInstances()
      .then(
        res => {
          this.taskInstances = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public retrieveMyAssignedTaskInstances(): void {
    this.isFetching = true;

    this.taskInstanceService()
      .retrieveMyAssignedTaskInstances()
      .then(
        res => {
          this.taskInstances = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }
}
