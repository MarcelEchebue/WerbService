<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\FormulaireController;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "api" middleware group. Make something great!
|
*/
Route::resource('formulaires', 'FormulairesController');

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});
// Route pour récupérer tous les extraits de naissance
Route::get('/formulaires', [FormulaireController::class, 'index']);

// Route pour récupérer un extrait de naissance spécifique
Route::get('/formulaires/{id}', [FormulaireController::class, 'show']);

// Route pour créer un nouvel extrait de naissance
Route::post('/formulaires', [FormulaireController::class, 'store']);

// Route pour mettre à jour un extrait de naissance existant
Route::put('/formulaires/{id}', [FormulaireController::class, 'update']);

// Route pour supprimer un extrait de naissance
Route::delete('/formulaires/{id}', [FormulaireController::class, 'destroy']);