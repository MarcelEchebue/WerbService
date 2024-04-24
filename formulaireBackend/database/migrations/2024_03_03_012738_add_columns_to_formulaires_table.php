<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::table('formulaires', function (Blueprint $table) {
            $table->string('nombre');
            $table->string('apellido');
            $table->integer('edad');
            $table->string('nombre_padre');
            $table->string('nombre_madre');
            // Agrega más columnas según sea necesario
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::table('formulaires', function (Blueprint $table) {
            $table->dropColumn('nombre');
            $table->dropColumn('apellido');
            $table->dropColumn('edad');
            $table->dropColumn('nombre_padre');
            $table->dropColumn('nombre_madre');
            // Elimina más columnas según sea necesario
        });
    }
};
