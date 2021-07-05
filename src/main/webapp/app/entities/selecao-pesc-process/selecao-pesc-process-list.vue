<template>
  <div>
    <h2 class="jh-entity-heading" data-cy="selecaoPescProcessDetailsHeading">
      <span v-text="$t('selecaoPescApp.selecaoPescProcess.home.title')">SelecaoPescProcess</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('selecaoPescApp.selecaoPescProcess.home.refreshListLabel')">Refresh List</span>
        </button>

        <router-link :to="`/process-definition/SelecaoPescProcess/init`" tag="button" class="btn btn-primary mr-2">
          <font-awesome-icon icon="plus"></font-awesome-icon>
          <span v-text="$t('selecaoPescApp.selecaoPescProcess.home.createLabel')"> Create a new Travel Plan Process Instance </span>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && selecaoPescProcessList && selecaoPescProcessList.length === 0">
      <span v-text="$t('selecaoPescApp.selecaoPescProcess.home.notFound')">No selecaoPescProcess found</span>
    </div>
    <div class="table-responsive" v-if="selecaoPescProcessList && selecaoPescProcessList.length > 0">
      <table class="table table-striped" aria-describedby="selecaoPescProcessList">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('selecaoPescApp.selecaoPescProcess.processInstance')">Process Instance</span></th>
            <th scope="row">Selecao Pesc</th>
            <th scope="row"><span v-text="$t('selecaoPescApp.processInstance.status')">Status</span></th>
            <th scope="row"><span v-text="$t('selecaoPescApp.processInstance.startDate')">Start Date</span></th>
            <th scope="row"><span v-text="$t('selecaoPescApp.processInstance.endDate')">End Date</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="selecaoPescProcess in selecaoPescProcessList" :key="selecaoPescProcess.id" data-cy="entityTable">
            <td>{{ selecaoPescProcess.id }}</td>
            <td>
              <div v-if="selecaoPescProcess.processInstance">
                <router-link :to="`/process-definition/SelecaoPescProcess/instance/${selecaoPescProcess.processInstance.id}/view`">
                  {{ selecaoPescProcess.processInstance.businessKey }}
                </router-link>
              </div>
            </td>
            <td>
              <div v-if="selecaoPescProcess.selecaoPesc">
                <router-link :to="{ name: 'SelecaoPescView', params: { selecaoPescId: selecaoPescProcess.selecaoPesc.id } }">{{
                  selecaoPescProcess.selecaoPesc.id
                }}</router-link>
              </div>
            </td>
            <td>
              <akip-show-process-instance-status :status="selecaoPescProcess.processInstance.status"></akip-show-process-instance-status>
            </td>
            <td>
              {{
                selecaoPescProcess.processInstance.startDate ? $d(Date.parse(selecaoPescProcess.processInstance.startDate), 'short') : ''
              }}
            </td>
            <td>
              {{ selecaoPescProcess.processInstance.endDate ? $d(Date.parse(selecaoPescProcess.processInstance.endDate), 'short') : '' }}
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="`/process-definition/SelecaoPescProcess/instance/${selecaoPescProcess.processInstance.id}/view`"
                  tag="button"
                  class="btn btn-info btn-sm details"
                  data-cy="entityDetailsButton"
                >
                  <font-awesome-icon icon="eye"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                </router-link>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
      <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
    </button>
  </div>
</template>

<script lang="ts" src="./selecao-pesc-process-list.component.ts"></script>
