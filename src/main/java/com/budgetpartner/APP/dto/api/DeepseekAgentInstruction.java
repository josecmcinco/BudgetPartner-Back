package com.budgetpartner.APP.dto.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class DeepseekAgentInstruction {
    private String toolName;  // Ejemplo: "MiembroTools.crearMiembro"
    private List<String> arguments; // Lista de argumentos
    private boolean finished; // Indica si la tarea terminó
    private String finalResponse; // Respuesta final para el usuario (si finished == true)


    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public String getFinalResponse() {
        return finalResponse;
    }

    public void setFinalResponse(String finalResponse) {
        this.finalResponse = finalResponse;
    }


    public static DeepseekAgentInstruction fromJson(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, DeepseekAgentInstruction.class);
        } catch (Exception e) {
            throw new RuntimeException("Error al deserializar JSON a DeepseekAgentInstruction", e);
        }
    }
}
