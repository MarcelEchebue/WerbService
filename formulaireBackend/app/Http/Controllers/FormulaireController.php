<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Formulaire;
use App\Http\Resources\FormulaireResource;

class FormulaireController extends Controller
{
    public function index()
    {
        $formulaires = Formulaire::all();
        return FormulaireResource::collection($formulaires);
    }

    // Método para mostrar un formulario específico
    public function show($id)
    {
        $formulaire = Formulaire::findOrFail($id);
        return new FormulaireResource($formulaire);
    }

    // Método para almacenar un nuevo formulario
    public function store(Request $request)
    {
        $formulaire = Formulaire::create($request->all());
        return new FormulaireResource($formulaire);
    }

    // Método para actualizar un formulario existente
    public function update(Request $request, $id)
    {
        $formulaire = Formulaire::findOrFail($id);
        $formulaire->update($request->all());
        return new FormulaireResource($formulaire);
    }

    // Método para eliminar un formulario
    public function destroy($id)
    {
        $formulaire = Formulaire::findOrFail($id);
        $formulaire->delete();
        return response()->json(null, 204);
    }
}
