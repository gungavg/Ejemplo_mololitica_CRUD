import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path: '',
        loadComponent: () => import('./student-list/student-list.component')
    },
    {
        path: 'new',
        loadComponent: () => import('./student-form/student-form.component')
    },
    {
        path: ':id/edit',
        loadComponent: () => import('./student-form/student-form.component')
    }

];
