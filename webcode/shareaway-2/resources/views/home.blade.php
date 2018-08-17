@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">Dashboard</div>

                <div class="card-body">
                    @if (session('status'))
                        <div class="alert alert-success" role="alert">
                            {{ session('status') }}
                        </div>
                    @endif
                    <div class="container">
                       <button class="btn btn-danger"><a href="" class="">wanna give ride</a></button>
                       <button class="btn btn-success " style="float:right;"><a href="">wanna take ride</a></button>
                    
                    </div>
                   

                </div>
            </div>
        </div>
    </div>
</div>
@endsection
